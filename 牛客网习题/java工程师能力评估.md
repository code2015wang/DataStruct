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

## servlet  

servlet是运行在web服务器端的java程序，可以动态生成web页面，属于客户与服务器响应的中间层。实际上，在运行JSP时，服务器底层将jsp编译成一个java类，这个java类就是servlet。从概念上说，servlet是一种运行在服务器端的java程序，可以动态生成web页面。

一个servlet在服务器上最多会驻留一个实例。所以说第一次调用Servlet时，将会创建一个实例。在实例化的过程中，HttpServlet中init（）方法会调用。

Servlet有两个处理方法：doGet()和doPost()

事实上，客户端对servlet发送一个请求，服务器端会开启一个线程，这个线程会调用service（）方法，service（）方法会根据收到客户端请求类型来决定调用doGet()还是doPost()方法。

destroy（）在servlet实例消亡时自动调用。

一个普通的类，不可能成为Servlet，必须继承javax.servlet.http.HttpServlet,重写doPost（）和doGet()方法。

Servlet的生命周期分为5个阶段：加载、创建、初始化、处理客户请求、卸载。
(1)加载：容器通过类加载器使用servlet类对应的文件加载servlet
(2)创建：通过调用servlet构造函数创建一个servlet对象（创建servlet实例由servlet容器创建）
(3)初始化：调用init方法初始化
(4)处理客户请求：每当有一个客户请求，容器会创建一个线程来处理客户请求
(5)卸载：调用destroy方法让servlet自己释放其占用的资源

servlet是线程不安全的。

## Struts1 和 Struts2 的区别和对比

Action 类: 


• Struts1要求Action类继承一个抽象基类。Struts1的一个普遍问题是使用抽象类编程而不是接口，而struts2的Action是接口。 


• Struts 2
  Action类可以实现一个Action接口，也可实现其他接口，使可选和定制的服务成为可能。Struts2提供一个ActionSupport基类去
  实现 常用的接口。Action接口不是必须的，任何有execute标识的POJO对象都可以用作Struts2的Action对象。


线程模式: 


• Struts1
  Action是单例模式并且必须是线程安全的，因为仅有Action的一个实例来处理所有的请求。单例策略限制了Struts1 Action能作的事，并且要在开发时特别小心。Action资源必须是线程安全的或同步的。


• Struts2 Action对象为每一个请求产生一个实例，因此没有线程安全问题。（实际上，servlet容器给每个请求产生许多可丢弃的对象，并且不会导致性能和垃圾回收问题）


Servlet 依赖: 


• Struts1 Action 依赖于Servlet API
  ,因为当一个Action被调用时HttpServletRequest 和 HttpServletResponse 被传递给execute方法。


• Struts 2
  Action不依赖于容器，允许Action脱离容器单独被测试。如果需要，Struts2
  Action仍然可以访问初始的request和response。但是，其他的元素减少或者消除了直接访问HttpServetRequest 和 HttpServletResponse的必要性。


可测性: 


• 测试Struts1
  Action的一个主要问题是execute方法暴露了servlet API（这使得测试要依赖于容器）。一个第三方扩展－－Struts TestCase－－提供了一套Struts1的模拟对象（来进行测试）。


• Struts 2 Action可以通过初始化、设置属性、调用方法来测试，“依赖注入”支持也使测试更容易。 


捕获输入: 


• Struts1

使用ActionForm对象捕获输入。所有的ActionForm必须继承一个基类。因为其他JavaBean不能用作ActionForm，开发者经常创建多余的类捕获输入。动态Bean（DynaBeans）可以作为创建传统ActionForm的选择，但是，开发者可能是在重新描述(创建)已经存
 在的JavaBean（仍然会导致有冗余的javabean）。


• Struts
  2直接使用Action属性作为输入属性，消除了对第二个输入对象的需求。输入属性可能是有自己(子)属性的rich对象类型。Action属性能够通过
  web页面上的taglibs访问。Struts2也支持ActionForm模式。rich对象类型，包括业务对象，能够用作输入/输出对象。这种
  ModelDriven 特性简化了taglib对POJO输入对象的引用。


表达式语言： 


• Struts1 整合了JSTL，因此使用JSTL EL。这种EL有基本对象图遍历，但是对集合和索引属性的支持很弱。 


•
  Struts2可以使用JSTL，但是也支持一个更强大和灵活的表达式语言－－"Object Graph Notation
  Language" (OGNL). 

## AWT 和 Swing

AWT提供了一套与本地图形界面进行交互的接口，是java提供的用来建立和设置java的图形界面的基本工具。但AWT所提供的图形功能是各种操作系统所提供的图形功能的交集。保证了同一程序的GUI在不同机器上运行具有类似的外观（不一定完全一致）。

Swing 是一个为Java设计的GUI工具包。

Swing是JAVA基础类的一部分。

Swing包括了图形用户界面（GUI）器件如：文本框，按钮，分隔窗格和表。

Swing提供许多比AWT更好的屏幕显示元素。它们用纯Java写成，所以同Java本身一样可以跨平台运行，这一点不像AWT。它们是JFC的一部分。它们支持可更换的面板和主题（各种操作系统默认的特有主题），然而不是真的使用原生平台提供的设备，而是仅仅在表面上模仿它们。这意味着你可以在任意平台上使用JAVA支持的任意面板。轻量级组件的缺点则是执行速度较慢，优点就是可以在所有平台上采用统一的行为

## 加载驱动的1三种方法

  加载驱动方法

  1.Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

2. DriverManager.registerDriver(new com.mysql.jdbc.Driver());

3.System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");

## 线程生命周期

每个线程都要经历创建、就绪、运行、阻塞和死亡5个状态。

1. 创建状态

创建状态是线程已被创建但未开始执行的一个特殊状态。此时线程对象拥有自己的内存空间，但没有分配cpu资源，需要通过start（）方法调度进入就绪状态等待cpu资源。

```java
Thread thread1 = new Thread()
```

2. 就绪状态

处于创建状态的线程对象通过start（）方法进入就绪状态。处于就绪状态的新城已经被放在某一队列中等待系统为其分配cpu控制权。至于何时真正的执行，取决于线程的优先级以及队列当前状态。

```java
thread1.start（）
```

3. 运行状态

若线程处于运行状态，表示线程已经拥有了对处理器的控制权，其代码目前正在运行，除非运行过程中控制权被另一个优先级的线程抢占，否则这一线程将一直持续到运行完毕。一个线程在以下情形下将释放对cpu的控制权，进入**不可运行的状态。**

+ 主动或被动释放对cpu资源的控制权
+ 线程调用yield（）或sleep（）方法。sllep（）方法中的参数为休眠时间，当这个时间过去后，线程即为可运行的。线程调用sleep（）方法后，不但给同优先级的线程一个可执行机会，对于低于优先级的线程同样有机会获得。但对于yeild（）方法，只给相同优先级的线程一个可执行的机会。如果当前系统中没有同优先级的线程，yield（）方法调用不会产生任何效果，当前线程继续执行。
+ 线程被挂起，即调用suspend（）方法。该线程须由其他线程调用resume（）方法来恢复执行。在最新的jdk中suspend（）和resume（）作废，但可以用wait（）和notify（）达到同样效果。
+ 为等候一个条件变量，线程调用了wait（）方法。如果需要停止等待的话，需要包含该条件变量的对象调用notify（）和notifyall（）方法。
+ 输入输出流中发生堵塞。

4. 阻塞状态

如果一个线程处于阻塞状态，那麽该线程则无法进入就绪状态。处于阻塞状态的线程通常必须由某些事情唤醒。

5. 死亡状态

死亡状态表示线程已退出运行状态，并且不再进入就绪状态。

创建状态

​     |

就绪状态    ——————|

​      |                        阻塞状态

运行状态 ———————|

​     |

死亡状态

```java
public class Square {  
    long width;  
    public Square(long l) {   
        width = l;  
    }  
    public static void main(String arg[]) { 
      //声明3个Square类型的a、b、c
      //在stack中分配三个内存，名字为a、b、c
        Square a, b, c;  
      //在heap中分配一块新内存，里面包含成员变量 width=42l，然后stack中a指向这块内存
        a = new Square(42L);   
      //在和eap中分配一块新内存，里面包含成员变量width=42l，然后tack中b指向这块内存
        b = new Square(42L);   
      //stack中c也指向b所指的那块内存
        c = b;   
      //在stack中分配一块内存，值为42l。
        long s = 42L;  
    } 
}
```

```java
Integer i01 = 59;
int i02 = 59;
Integer i03 =Integer.valueOf(59);
Integer i04 = new Integer(59)。
```

  Integer i01=59  的时候，会调用  Integer  的  valueOf  方法，

  这个方法就是返回一个  Integer  对象，只是在返回之前，看作了一个判断，判断当前  i  的值是否在  [-128,127]  区别，且  IntegerCache  中是否存在此对象，如果存在，则直接返回引用，否则，创建一个新的对象。

  在这里的话，因为程序初次运行，没有  59  ，所以，直接创建了一个新的对象。

  int i02=59  ，这是一个基本类型，存储在栈中。   

  Integer i03 =Integer.*valueOf*(59);  因为  IntegerCache  中已经存在此对象，所以，直接返回引用。   

  Integer i04 = new   Integer(59)  ；直接创建一个新的对象。   

  System. out .println(i01== i02); i01  是  Integer  对象，  i02  是  int  ，这里比较的不是地址，而是值。  Integer  会自动拆箱成  int  ，然后进行值的比较。所以，为真。   

  System. out  .println(i01== i03);  因为  i03  返回的是  i01  的引用，所以，为真。   

  System.  out  .println(i03==i04);  因为  i04  是重新创建的对象，所以  i03,i04  是指向不同的对象，因此比较结果为假。   

  System.   out  .println(i02== i04);  因为  i02  是基本类型，所以此时  i04  会自动拆箱，进行值比较，所以，结果为真。

## java中异常

  trowable 的子类 error 和 Exception

  Exception 包括 非检查性异常 RuntimeException，  及其子类，即运行时的异常，运行时的异常是代码的BUG，

  和检查性异常，即非运行时异常，程序在编译的时候会发现的异常 如: IOException之类,在处理类似文件流的时候，java强制规定必须处理可能遇到的文件流异常。

  runtimeException是运行时的异常，在运行期间抛出异常的超类，程序可以选择是否try-catch处理。

  其他的检查性异常（非运行时的异常，如IOException），是必须try-catch的，否则程序在编译的时候就会发现错误。

## struts工作原理

  MVC即Model-View-Controller的缩写，是一种常用的设计模式。MVC  
  减弱了业务逻辑接口和数据接口之间的耦合，以及让视图层更富于变化。 
 Struts   是MVC的一种实现，它将   Servlet和
    JSP   标记（属于   J2EE  
  规范）用作实现的一部分。Struts继承了MVC的各项特性，并根据J2EE的特点，做了相应的变化与扩展。 
 控
  制：有一个XML文件Struts-config.xml，与之相关联的是Controller，在Struts中，承担MVC中Controller角
  色的是一个Servlet，叫ActionServlet。ActionServlet是一个通用的控制组件。这个控制组件提供了处理所有发送到
  Struts的HTTP请求的入口点。它截取和分发这些请求到相应的动作类（这些动作类都是Action类的子类）。另外控制组件也负责用相应的请求参数
  填充   Action  
  From（通常称之为FromBean）,并传给动作类（通常称之为ActionBean）。动作类实现核心商业逻辑，它可以访问java  
  bean    或调用EJB。最后动作类把控制权传给后续的JSP  
  文件，后者生成视图。所有这些控制逻辑利用Struts-config.xml文件来配置。 

  视图：主要由JSP生成页面完成视图，Struts提供丰富的JSP   标签库：  
  Html，Bean，Logic，Template等，这有利于分开表现逻辑和程序逻辑。 
 模 型：模型以一个或多个java  
  bean的形式存在。这些bean分为三类：Action   Form、Action、JavaBean   or    EJB。Action

  Form通常称之为FormBean，封装了来自于Client的用户请求信息，如表单信息。Action通常称之为ActionBean，获取从
  ActionSevlet传来的FormBean，取出FormBean中的相关信息，并做出相关的处理，一般是调用Java  
  Bean或EJB等。 
 流程：在Struts中，用户的请求一般以*.do作为请求服务名，所有的*.do请求均被指向
  ActionSevlet，ActionSevlet根据Struts-config.xml中的配置信息，将用户请求封装成一个指定名称的
  FormBean，并将此FormBean传至指定名称的ActionBean，由ActionBean完成相应的业务操作，如文件操作，数据库操作等。
  每一个*.do均有对应的FormBean名称和ActionBean名称，这些在Struts-config.xml中配置。 
 核心：Struts的核心是ActionSevlet，ActionSevlet的核心是Struts-config.xml。

## jsp 中动态include和静态include的区别

​    动态
​    INCLUDE
​    用
​    jsp:include
​    动作实现
​     <jsp:include page="included.jsp"
​      flush="true" />
​    它总是会检查所含文件中的变化
​    ,
​    适合用于包含动态页面
​    ,
​    并且可以带参数。各个文件分别先编译，然后组合成一个文件。
​    静态
​    INCLUDE
​    用
​    include
​    伪码实现
​    ,
​    定不会检查所含文件的变化
​    ,
​    适用于包含静态页面
​    <%@ include file="included.htm" %>
​    。先将文件的代码被原封不动地加入到了主页面从而合成一个文件，然后再进行翻译，此时不允许有相同的变量。

​    以下是对    include     两种用法的区别    ，    主要有两个方面的不同    ;  

​            一    执行时间上    :  

​        <%@ include file="relativeURI"%>     是在翻译阶段执行  

​        <jsp:include page="relativeURI"      flush="true" />     在请求处理阶段执行    .  

​            二    :    引入内容的不同    :  

​        <%@ include file="relativeURI"%>  

​            引入静态文本    (html,jsp),    在    JSP    页面被转化成    servlet    之前和它融和到一起    .  

​        <jsp:include page="relativeURI"      flush="true" />    引入执行页面或    servlet    所生成的应答文本    .  