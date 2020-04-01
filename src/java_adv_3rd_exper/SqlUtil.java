package java_adv_3rd_exper;

import java.util.List;

public interface SqlUtil {
	// 根据传入的参数返回查询语句
	String query(User user);
	// 根据传入的参数返回插入语句
	String insert(User user);
	// 根据传入的参数返回插入语句
	String insert(List<User> users);
	// 根据传入的参数返回删除语句(删除id为user.id的记录)
	String delete(User user);
	// 根据传入的参数返回更新语句(将id为user.id的记录的其他字段更新成user中的对应值)
	String update(User user);
}
