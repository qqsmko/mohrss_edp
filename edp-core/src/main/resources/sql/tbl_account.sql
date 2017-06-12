
DROP TABLE IF EXISTS "public"."tbl_account";
CREATE TABLE "public"."tbl_account" (
"id" serial,
"user_id" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"account" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"password" varchar(128) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"login_ip" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"login_time" timestamp(6) NOT NULL,
"enable" int2 DEFAULT 1 NOT NULL,
"is_locked" int2 DEFAULT 0 NOT NULL,
"is_expired" int2 DEFAULT 0 NOT NULL,
"dead_line" timestamp(6) DEFAULT '2030-01-01 00:00:00'::timestamp without time zone NOT NULL,
"create_time" timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,
"update_time" timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tbl_account" IS '账号信息表';
COMMENT ON COLUMN "public"."tbl_account"."id" IS '主键';
COMMENT ON COLUMN "public"."tbl_account"."user_id" IS '用户Id';
COMMENT ON COLUMN "public"."tbl_account"."account" IS '账号';
COMMENT ON COLUMN "public"."tbl_account"."password" IS '密码(密文)';
COMMENT ON COLUMN "public"."tbl_account"."login_ip" IS '最近一次登录Ip';
COMMENT ON COLUMN "public"."tbl_account"."login_time" IS '最近一次登录时间';
COMMENT ON COLUMN "public"."tbl_account"."enable" IS '账号是否可用，0=不可用，1=可用';
COMMENT ON COLUMN "public"."tbl_account"."is_locked" IS '账号是否锁定，0=未锁定，1=锁定';
COMMENT ON COLUMN "public"."tbl_account"."is_expired" IS '账号是否过期，0=未过期，1=过期';
COMMENT ON COLUMN "public"."tbl_account"."dead_line" IS '过期时间';
COMMENT ON COLUMN "public"."tbl_account"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."tbl_account"."update_time" IS '更新时间';

CREATE INDEX "idx_user_id" ON "public"."tbl_account" USING btree ("user_id");


ALTER TABLE "public"."tbl_account" ADD UNIQUE ("account");


ALTER TABLE "public"."tbl_account" ADD PRIMARY KEY ("id");


insert into tbl_account
(user_id,
account,
password,
login_ip,
login_time,
enable,
is_locked,
is_expired,
create_time,
update_time)
values
(
'USER17061211232456024430',
'root',
'$2a$10$kGiMVpZWQ0z8z46u5e5pyOfZpZ03/PYp7HJ30FnXmRMo2.GrtRfIm',
'',
now(),
1,
0,
0,
now(),
now()
);

insert into tbl_account
(user_id,
account,
password,
login_ip,
login_time,
enable,
is_locked,
is_expired,
create_time,
update_time)
values
(
'USER17061213413856038626',
'teacher',
'$2a$10$aqd02rUr5zotpeJy02Tg/er..UhC90.yn/Gwa.ZxuwyYPvUHC0iDS',
'',
now(),
1,
0,
0,
now(),
now()
);
