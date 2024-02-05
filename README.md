-----------------------2nd task-----------------
create table usersCollection(user_id Serial Not Null Primary key,
                      user_name varchar(200)
                      );
select * from usersCollection;                      
insert into usersCollection(user_name) values('JohnDoe'),('JaneSmith'),('BobJohnson') ;     


create table postsCollections(user_id Serial Not Null Primary key,
                      user_title varchar(200),
                      user_content varchar(200)       
                      );
                      
insert into postsCollections(user_id,user_title,user_content) values(101,'post1','Lorem ipsum 1'),
                             (102,'post2','Lorem ipsum 2'),
                             (103,'post3','Lorem ipsum 3'),
                             (104,'post4','Lorem ipsum 4');
                             
select * from postsCollections;

query -> SELECT  u.username, u.name, p.title, p.content
         FROM users u
         INNER JOIN posts p ON u._id = p.user_id;


-----------------------------3rd task----------
query for 3rd-> SELECT
                u._id ,
                u.username,
                u.name
                FROM
                users u
                LEFT JOIN
                posts p ON u._id = p.user_id;
    
