drop table if exists `account`;

create table `account`(
`name` varchar(16) not null UNIQUE,
`pwd` VARCHAR(32) not null,
`email` VARCHAR(64),
`phone` varchar(12),
`create_time` TIMESTAMP default now(),
`update_time` TIMESTAMP,
PRIMARY key (`name`)
) ENGINE = INNODB DEFAULT CHARSET = 'utf8mb4';


drop table if exists `consumption_type`;

create table `consumption_type`(
`id` SMALLINT not null auto_increment PRIMARY key,
`name` VARCHAR(255),
`desc` VARCHAR(255)
) ENGINE = INNODB DEFAULT CHARSET = 'utf8mb4';



drop table if exists `pay_type`;

create table `pay_type`(
 `id` SMALLINT not null auto_increment PRIMARY key,
 `name` VARCHAR(64),
 `desc` VARCHAR(255)
) ENGINE = INNODB DEFAULT CHARSET = 'utf8mb4';


drop table if exists `consumption_record`;

create table consumption_record(
`id` bigint not null auto_increment,
`type` smallint not null,
`pay_type` smallint not null,
`time` date,
`amount` DECIMAL(10,3),
`comment` VARCHAR(512),
`create_time` TIMESTAMP default now(),
PRIMARY key (id),
FOREIGN KEY (type) REFERENCES consumption_type(id),
FOREIGN key (pay_type) REFERENCES pay_type(id)
)ENGINE= INNODB default charset = 'utf8mb4';


drop table if exists `consumption_statistic`;

create table `consumption_statistic`(
`id` bigint not null auto_increment primary key,
`begin` date,
`end` date,
`type` smallint,
`pay_type` smallint,
`total` decimal(10,3),
FOREIGN KEY (type) REFERENCES consumption_type(id),
FOREIGN key (pay_type) REFERENCES pay_type(id)
)ENGINE= INNODB default charset = 'utf8mb4';







# insert into account(`name`, `pwd`, `email`, `phone`) values('admin', 'admin', 'laohu9024@163.com', '186648555436');

# insert into consumption_type(`name`, `desc`) values('房租','租房支出');
# insert into consumption_type(`name`, `desc`) values('水电', '水电支出');
# insert into consumption_type(`name`, `desc`) values('生活用品', '日用品');
# insert into consumption_type(`name`, `desc`) values('服装', '衣服、鞋等');
# insert into consumption_type(`name`, `desc`) values('充值缴费', '电话费用');
# insert into consumption_type(`name`, `desc`) values('交通出行', '交通费');
# insert into consumption_type(`name`, `desc`) values('酒店旅行', '酒店住宿，旅行');
# insert into consumption_type(`name`, `desc`) values('餐饮美食', '吃饭，喝水');
# insert into consumption_type(`name`, `desc`) values('其他', '未分类');

# insert into pay_type(`name`, `desc`) values('支付宝','');
# insert into pay_type(`name`, `desc`) values('微信','');
# insert into pay_type(`name`, `desc`) values('招商银行信用卡','');
# insert into pay_type(`name`, `desc`) values('民生银行储蓄卡','');
# insert into pay_type(`name`, `desc`) values('农业银行储蓄卡','');



 select t1.`id`, t1.`time`, t1.`amount`, t1.`comment`, t1.`create_time`, t2.`name` as consumption_type_name , t3.`name` as pay_type_name from `consumption_record` t1, `consumption_type` t2, `pay_type` t3  
 
 where t1.`type` = t2.`id`  and t1.`pay_type` = t3.`id` order by `time` desc;


select sum(t1.`amount`) as total, t2.`id` as consumption_type, t2.`name` as consumption_type_name,  t3.`id` as pay_type, t3.`name` as pay_type_name from consumption_record t1, consumption_type t2, pay_type t3 
where t1.time >= date_format('2020-07-01', '%Y-%m-%d') and t1.time <= date_format('2020-07-31', '%Y-%m-%d')
and t2.id=1 and t3.id = 1  and t1.type = 


select sum(t1.`amount`) as total, t2.`id` as consumption_type, t2.`name` as consumption_type_name, t3.`id` as pay_type, t3.`name` as pay_type_name from consumption_record t1, consumption_type t2, pay_type t3 where t1.time >= date_format('2020-07-08', '%Y-%m-%d') AND t1.time <= date_format('2020-07-31', '%Y-%m-%d') and t1.type=1 and t1.type = t2.id and t1.pay_type = 2 and t1.pay_type = t3.id


 select sum(t1.`amount`) as total, t2.`id` as consumption_type, t2.`name` as consumption_type_name, t3.`id` as pay_type, t3.`name` as pay_type_name from consumption_record t1, consumption_type t2, pay_type t3 where t1.time >= date_format('2020-07-01', '%Y-%m-%d') AND t1.time <= date_format('2020-07-31', '%Y-%m-%d') and t1.type = t2.id and t1.pay_type = t3.id
 GROUP BY t2.id, t3.id
 ;

select sum(t1.amount) from consumption_record t1;


update `consumption_record` set `type`=?, `pay_type`=?, `time`=?,`amount`=?,`comment`=? where `id`=?





