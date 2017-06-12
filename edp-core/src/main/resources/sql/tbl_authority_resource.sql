
DROP TABLE IF EXISTS "public"."tbl_authority_resource";
CREATE TABLE "public"."tbl_authority_resource" (
"id" serial,
"authority_id" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"resource_id" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tbl_authority_resource" IS '权限资源关联表';
COMMENT ON COLUMN "public"."tbl_authority_resource"."id" IS '主键';
COMMENT ON COLUMN "public"."tbl_authority_resource"."authority_id" IS '权限Id';
COMMENT ON COLUMN "public"."tbl_authority_resource"."resource_id" IS '资源Id';


CREATE INDEX "tbl_authority_resource_authority_id_idx" ON "public"."tbl_authority_resource" USING btree ("authority_id");
CREATE INDEX "tbl_authority_resource_resource_id_idx" ON "public"."tbl_authority_resource" USING btree ("resource_id");


ALTER TABLE "public"."tbl_authority_resource" ADD PRIMARY KEY ("id");
