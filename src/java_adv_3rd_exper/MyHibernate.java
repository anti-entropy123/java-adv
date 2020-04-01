package java_adv_3rd_exper;

import java.lang.reflect.Field;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class MyHibernate implements SqlUtil{
	public ArrayList<Field> getFields(User user) {
		List<String> columns = new ArrayList();
		List<String> values = new ArrayList();
		ArrayList<Field> fields= new ArrayList<Field>(Arrays.asList(User.class.getFields()));
		ArrayList<Field> fieldsPrivate = new ArrayList<Field>(Arrays.asList(User.class.getDeclaredFields()));
		fields.addAll(fieldsPrivate);
		return fields;
	}
	public String getValue(Field field, User user) {
		field.setAccessible(true);
		String result;
		try {
			Object val = field.get(user);
			if(val == null) return null;
			result = val instanceof String?(String)val:String.valueOf(val);
		}catch(Exception e) {
			e.printStackTrace();
			result = null;
		}
		return result;
	}
	// 根据传入的参数返回查询语句
	public String query(User user) {
		ArrayList<String> conditions = new ArrayList<String>();
		ArrayList<Field> fields = getFields(user);
		for(Field field: fields) {
			Column c = field.getAnnotation(Column.class);
			if(c!=null) {
				String condition = null;
				String key = c.value();
				field.setAccessible(true);
				try {
					Object val = field.get(user);
					if(val!=null && val instanceof String) {
						condition = field.getName() + " LIKE '"+(String)val+"'";
						conditions.add(condition);
					}else if(val != null && !val.equals(0)){
						condition = field.getName() + "='" + String.valueOf(val);
						conditions.add(condition);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		String condition = String.join(" AND ", conditions);
		String sql = "SELECT * FROM %s WHERE %s;";
		Table table = user.getClass().getAnnotation(Table.class);
		return table==null? null: String.format(sql, table.value(), condition);
	}

	// 根据传入的参数返回插入语句
	public String insert(User user) {
		String tableName = user.getClass().getAnnotation(Table.class).value();
		List<String> columns = new ArrayList();
		List<String> values = new ArrayList();
		ArrayList<Field> fields = getFields(user);
		for(Field field: fields) {
			Column c = field.getAnnotation(Column.class);
			if(c!=null){
				columns.add(c.value());
				String value = getValue(field, user)==null?"null":getValue(field, user);
				values.add("'"+(value)+"'");
			}
		}
		String columnsName = String.join(", ", columns);
		String value = String.join(", ", values);
		String sql = "INSERT INTO %s(%s) VALUES(%s);";
		return String.format(sql, tableName, columnsName, value);
	}
	// 根据传入的参数返回插入语句
	public String insert(List<User> users) {
		User user = users.get(0);
		String tableName = user.getClass().getAnnotation(Table.class).value();
		ArrayList<Field> fields = getFields(user);
		List<String> columns = new ArrayList<String>();
		for(Field field: fields) {
			Column c = field.getAnnotation(Column.class);
			if(c!=null){
				columns.add(c.value());
			}
		}
		String fieldNames = String.join(", ",columns);
		ArrayList<String> totalValues = new ArrayList<String>();
		for(User user2: users) {
			ArrayList<Field> fields2 = getFields(user2);
			ArrayList<String> values2 = new ArrayList<String>();
			for(Field field2: fields2) {
				if(field2.getAnnotation(Column.class)!=null){
					values2.add("'"+ getValue(field2, user2)==null?"null":getValue(field2, user2) +"'");
				}
			}
			totalValues.add("("+String.join(", ",values2) +")");
		}
		return String.format("INSERT INTO %s(%s) VALUES%s'", tableName, fieldNames, String.join(", ", totalValues));
	}
	// 根据传入的参数返回删除语句(删除id为user.id的记录)
	public String delete(User user) {
		String tableName = user.getClass().getAnnotation(Table.class).value();
		ArrayList<Field> fields = getFields(user);
		String where="";
		for(Field field: fields) {
			Column c = field.getAnnotation(Column.class);
			if(c!=null) {
				if(field.getName().equals("id")) {
					where = field.getName()+"="+getValue(field, user);
					break;
				}
			}
		}
		return String.format("DELETE FROM %s WHERE %s;", tableName, where);
	}
	// 根据传入的参数返回更新语句(将id为user.id的记录的其他字段更新成user中的对应值)
	public String update(User user) {
		String tableName = user.getClass().getAnnotation(Table.class).value();
		ArrayList<Field> fields = getFields(user);
		String where="";
		ArrayList<String> datas = new ArrayList<String>();
		for(Field field: fields) {
			Column c = field.getAnnotation(Column.class);
			if(c!=null && getValue(field, user)!=null) {
				if(field.getName().equals("id")) {
					where = field.getName()+"="+getValue(field, user);
				}else {
					datas.add(field.getName()+"='"+getValue(field, user)+"'");
				}
			}
		}
		return String.format("UPDATE %s SET %s WHERE %s;", tableName, String.join(", ", datas), where);
	}
}
