
DROP TABLE IF EXISTS "public"."tbl_access_resource";
CREATE TABLE "public"."tbl_access_resource" (
"id" serial,
"resource_id" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"resource_name" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"resource_desc" varchar(50) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"resource_path" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"enable" int2 DEFAULT 1 NOT NULL,
"create_time" timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,
"update_time" timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tbl_access_resource" IS '访问资源表';
COMMENT ON COLUMN "public"."tbl_access_resource"."id" IS '主键';
COMMENT ON COLUMN "public"."tbl_access_resource"."resource_id" IS '资源Id';
COMMENT ON COLUMN "public"."tbl_access_resource"."resource_name" IS '资源名称';
COMMENT ON COLUMN "public"."tbl_access_resource"."resource_desc" IS '资源描述';
COMMENT ON COLUMN "public"."tbl_access_resource"."resource_path" IS '资源路径';
COMMENT ON COLUMN "public"."tbl_access_resource"."enable" IS '资源是否可用，0=不可用，1=可用';
COMMENT ON COLUMN "public"."tbl_access_resource"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."tbl_access_resource"."update_time" IS '更新时间';

ALTER TABLE "public"."tbl_access_resource" ADD UNIQUE ("resource_id");

ALTER TABLE "public"."tbl_access_resource" ADD PRIMARY KEY ("id");


insert into tbl_access_resource
(resource_id,
resource_name,
resource_desc,
resource_path,
enable,
create_time,
update_time)
values
(
'RESOURCE17061213580356003766',
'URL_attendance_list',
'查询学员考勤记录',
'/attendance-list',
1,
now(),
now()
);

insert into tbl_access_resource
(resource_id,
resource_name,
resource_desc,
resource_path,
enable,
create_time,
update_time)
values
(
'RESOURCE17061213580356003767',
'URL_class-add',
'添加培训课程',
'/class-add',
1,
now(),
now()
);

