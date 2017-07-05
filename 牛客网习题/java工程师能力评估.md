1. jvm 内存

对于java程序员来说，在虚拟机自动内存管理机制下，不再需要为每一个new操作去写对应的delete/free方法，不容易出现内存泄漏和内存溢出问题。java虚拟机所管理的内存将包括以下几个运行时数据区：程序计数器、方法区、虚拟机栈、本地方法栈和堆。其中方法区和堆是线程共享的而虚拟机栈、本地方法栈和程序计数器是非线程共享的。

概括的来说，jvm初始运行的时候都会分配好方法区和堆，而jvm每遇到一个线程，就为其分配一个程序计数器、虚拟机栈和本地方法栈，当线程终止时，三者（程序计数器、虚拟机栈和本地方法区）所占用的空间被释放掉。

+ 程序计数器 ： 是一块较小的空间，它可以看作是当前线程的所执行的字节码的行号指示器即指示当前线程的字节码执行到第几行。
+ java虚拟机栈 ： 虚拟机栈描述的是java方法执行的内存模型：每个方法执行的同时会创建一个栈帧用于存储局部变量、操作数栈、动态链接、方法出口等信息。每个方法从调用到执行完成的过程，就对应着一个栈帧在虚拟机栈中入栈到出栈的过程。
+ 本地方法栈： 与虚拟机栈所发挥的作用是类似的，他们之间的区别在于虚拟机栈是为虚拟机执行java方法服务的，而本地方法栈则是为虚拟机使用的native方法服务。
+ java 堆 ：对于大多数应用来说，java堆是java虚拟机所管理的内存中最大的一块，java堆是被所有线程共享的一块区域，在虚拟机启动时创建。此内存的唯一目的就是存放对象实例，几乎所有对象实例都在这里分配。
+ 方法区： 方法区和java堆一样，是各个线程共享的，它用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据。 

2. jdbc 连接数据库实例

```java
import java.sql.DriverManageer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
public clas MysqlDemo {
 public static void main(String[] args) throws Exception {
 Connection conn = null;
   String sql;
   //jdbc url 编写形式 : jdbc:mysql://主机名称:连接端口/数据库名称?参数=值
   String url = "jdbc:mysql://localhost:3306/javademo?"+"user=root&password=root&useUnicode=true&characterEncoding=UTF8";
   try{
     Class.forName("com.mysql.jdbc.Driver");//加载mysql驱动
     System.out.println("成功加载mysql驱动程序");
     //conn 代表数据库连接
     conn = DriverManager.getConnection(url);
     //Startement里有许多方法，如executeUpdate可以实现插入、更新和删除操作等。
     Statement  stmt = conn.createStatement();
     sql = "create tale student(NO char(20),name varchar(20),primary key (NO))";
     int result = stmt.executeUpdate(sql);
     if(result != -1){
       System.out.println("创建数据库成功");
       sql = "insert into student (NO,name ) values('2012001','陶伟基')";
       result = stmt.executeUpdate(sql);
       sql = "select * from student";
       //executeQuery会返回结果的集合，否则返回空值。
       ResultSet rs = stmt.executeQuery(sql);
       System.out.println("学号\t姓名");
       while(rs.next()){
         System.out.println(rs.getString(1)+"\t"+rs.getString(2));
       }
     }
   }catch(SQLEXception e){
     System.out.println("mysql 操作错误");
     e.printStackTrace();
   }catch(Exception e){
     e.printStackTrace();
   }finaly{
     conn.close();
   }
 }
}
```

jdbc连接数据库，包括7个步骤：

+ 加载jdbc驱动程序

```java
try {
  Class.forName("com.mysql.jdbc.Driver");
} catch(ClassNotFoundException e){
  e.printStackTrace();
}
```

+ 提供jdbc连接的URL

 String url = "jdbc:mysql://localhost:3306/javademo?"+"user=root&password=root&useUnicode=true&characterEncoding=UTF8";

+ 创建数据库连接 

```java
String url = "jdbc:mysql://localhost:3306/test";
String username = "root";
String password = "root";
try{
  Connection con = DriverManager.getConnection(url,username,password);
}catch(SQLException se ){
  System.out.println("数据库连接失败");
  se.printStackTrace();
}
```

+ 创建一个statement

要执行一个SQL语句，必须获得java.sql.Statement实例，Statement实例分为以下3种类型：

1. 执行静态SQL语句，通常通过Statement实例实现
2. 执行动态SQL语句，通常通过PreparedStatement实例实现
3. 执行数据库存储过程，通常通过CallableStatement实例实现

```java
Statement stmt = con.createStatement();
PreparedStatement pstmt = con.prepareStatement(sql);
CallableStatement cstmt = con.prepareCall("{CALL demoSp(?,?)}");
```

+ 执行SQL语句

Statement 接口提供了三种执行SQL语句的方法： execueQuery ，executeUpdate和 execute

1. ResultSet executeQuery（String sqlString）执行查询数据库的SQL语句，返回一个结果集对象
2. int executeUpdate（String sqlString） ：用于执行insert 、update或delete语句
3. execute（sqlString） ：用于执行返回多个结果集，多个更新计数或二着结合的语句

```java
ResultSet rs = stmt.executeQuery("select * from test");
int rows  = stmt.executeUpdate("insert into ...");
boolean flag = stmt.execute(string sql);
```

+ 处理结果 

两种情况：

1. 执行更新返回的是本次操作影响的记录数
2. 执行查询返回的结果是一个ResultSet对象

```java
while(rs.next()){
  String name = rs.getString("name");
  String pass = rs.getString(1);
}
```

+ 关闭jdbc对象

操作完成后要把所有的jdbc对象全部关闭，以释放jdbc资源，关闭顺序和声明顺序相反：

1. 关闭结果集
2. 关闭声明
3. 关闭连接对象

## spring 的事务管理

+ 事务属性值的实际意义
+ ThreadLocal的工作机制
+ Spring 事务管理的体系结构
+ 基于 XML的事务配置
+ 基于注解的事务配置

1. 数据库中的事务

数据库的事务必须满足4个特性：原子性、一致性、隔离性和持久性。数据库管理系统一般采用重执行日志记录保证原子性、一致性和持久性。和java程序采用对象锁机制进行线程同步类似，数据库管理系统采用数据库锁机制保证事务的隔离性。

2. jdbc对事务的支持

```java
Connection conn;
try{
  conn = DriverManager.getConnection();//获取数据库连接
  conn.setAutoCommit(false);//关闭自动提交
  conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);//设置事务隔离级别
  Statement stmt = conn.createStatement();
  int rows = stmt.executeUpdate("insert into t_topic values(1,"tom")");
  row stmt.executeUpdate("update t_user set topic_nums = topic_nums+1" + "where user_id = 1");
  conn.commit();//提交事务
}catch(Exception e){
  conn.rollback();//回滚事务
}finally{
  ....
}
```

3. ThreadLocal 是什么

ThreadLocal，它不是一个线程，而是线程的一个本地化对象。当工作于多线程中的对象使用ThreadLocal维护变量是，ThreadLocal为每个使用该变量的线程分配一个独立的变量副本，所以每一个线程都可以独立的改变自己的副本，而不影响其他线程所对应的副本。

4. spring中事务传播类型

| 事务传播行为类型                  | 说明                                       |
| ------------------------- | ---------------------------------------- |
| PROPAGATION_REQUIRED      | 如果当前没有事务，就新建一个事务，如果存在一个事务中，加入到事务中        |
| PROPAGATION_SUPPORTS      | 支持当前事务，如果当前没有事务，就以非事务方式执行                |
| PROPAGATION_MANDATORY     | 使用当前事务，如果当前没有事务，就抛出异常                    |
| PROPAGATION_REQUIRES_NEW  | 新建事务，如果当前存在事务，当前事务挂起                     |
| PROPAGATION_NOT_SUPPORTED | 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起             |
| PROPAGATION_NEVER         | 以非事务方式执行，如果当前存在事务，则抛异常                   |
| PROPAGATION_NESTED        | 如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似操作。 |

## servlet 与 CGI区别

servlet 处于服务器进程中，它通过多线程方式运行其seervice方法

CGI对每个请求都产生新的进程，服务完成后就销毁

servlet在易用性上强于cgi，它提供了大量的实用工具例程。

CGI不可移植，为特定平台编写的CGI应用只能运行于这一环境。每一个cgi应用存在于一个客户端请求激活的进程中，并且在请求被服务后被卸载。这种模式引起高内存、高CPU开销，而且在同一进程中不能服务多个客户。



