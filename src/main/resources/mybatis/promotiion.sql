

DROP TABLE IF EXISTS promotions;

CREATE TABLE promotions (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL COMMENT '促销名称',
  description VARCHAR(255) NOT NULL COMMENT '描述',
  position INTEGER NOT NULL DEFAULT '0' COMMENT '权重',
  type VARCHAR(100) NOT NULL COMMENT '促销类别 优惠卷/秒杀/聚划算/等待',
  config JSON DEFAULT NULL COMMENT '配置信息，JSON 格式的数据',
  began_at BIGINT DEFAULT NULL COMMENT '开始时间',
  ended_at BIGINT DEFAULT NULL COMMENT '结束时间'
 )ENGINE = InnoDB CHARSET ='utf8mb4' COMMENT '促销';



DROP TABLE IF EXISTS promotion_rules;

CREATE TABLE promotion_rules (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  promotion_id BIGINT NOT NULL COMMENT '促销 ID',
  type VARCHAR(255) NOT NULL COMMENT '规则类别',
  config JSON COMMENT '规则信息',
  create_time BIGINT COMMENT '创建时间' ,
  INDEX (promotion_id)

) ENGINE = InnoDB CHARSET ='utf8mb4' COMMENT '促销规则';



DROP TABLE IF EXISTS promotion_actions;

CREATE TABLE promotion_actions (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  promotion_id BIGINT NOT NULL COMMENT '促销 ID',
  type VARCHAR(255) NOT NULL COMMENT '动作类别',
  config JSON COMMENT '动作信息',
  create_time BIGINT COMMENT '创建时间' ,
  INDEX (promotion_id)

) ENGINE = InnoDB CHARSET ='utf8mb4' COMMENT '促销要执行的动作';
