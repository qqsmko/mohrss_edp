
DROP TABLE IF EXISTS "public"."tbl_role";
CREATE TABLE "public"."tbl_role" (
"id" serial,
"role_id" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"role_name" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"role_desc" varchar(50) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"priority" int2 DEFAULT 100 NOT NULL,
"enable" int2 DEFAULT 1 NOT NULL,
"create_time" timestamp(6) NOT NULL,
"update_time" timestamp(6) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tbl_role" IS '角色记录表';
COMMENT ON COLUMN "public"."tbl_role"."id" IS '主键';
COMMENT ON COLUMN "public"."tbl_role"."role_id" IS '角色Id';
COMMENT ON COLUMN "public"."tbl_role"."role_name" IS '角色名称，约定以ROLE_起始';
COMMENT ON COLUMN "public"."tbl_role"."role_desc" IS '角色描述';
COMMENT ON COLUMN "public"."tbl_role"."priority" IS '优先级,值越小优先级越大';
COMMENT ON COLUMN "public"."tbl_role"."enable" IS '角色是否可用，0=不可用，1=可用';
COMMENT ON COLUMN "public"."tbl_role"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."tbl_role"."update_time" IS '更新时间';


CREATE INDEX "tbl_role_role_id_idx" ON "public"."tbl_role" USING btree ("role_id");

ALTER TABLE "public"."tbl_role" ADD UNIQUE ("role_name");

ALTER TABLE "public"."tbl_role" ADD PRIMARY KEY ("id");
