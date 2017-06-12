
DROP TABLE IF EXISTS "public"."tbl_authority";
CREATE TABLE "public"."tbl_authority" (
"id" serial,
"authority_id" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"authority_name" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"authority_desc" varchar(50) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"prompt_message" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"enable" int2 DEFAULT 1 NOT NULL,
"create_time" timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,
"update_time" timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tbl_authority" IS '权限记录表';
COMMENT ON COLUMN "public"."tbl_authority"."id" IS '主键';
COMMENT ON COLUMN "public"."tbl_authority"."authority_id" IS '权限Id';
COMMENT ON COLUMN "public"."tbl_authority"."authority_name" IS '权限名称，约定以AUTH_起始';
COMMENT ON COLUMN "public"."tbl_authority"."authority_desc" IS '权限描述';
COMMENT ON COLUMN "public"."tbl_authority"."prompt_message" IS '提示信息';
COMMENT ON COLUMN "public"."tbl_authority"."enable" IS '资源是否可用，0=不可用，1=可用';
COMMENT ON COLUMN "public"."tbl_authority"."create_time" IS '创建时间';
COMMENT ON COLUMN "public"."tbl_authority"."update_time" IS '更新时间';

CREATE INDEX "idx_authority_id" ON "public"."tbl_authority" USING btree ("authority_id");


ALTER TABLE "public"."tbl_authority" ADD UNIQUE ("authority_name");


ALTER TABLE "public"."tbl_authority" ADD PRIMARY KEY ("id");
