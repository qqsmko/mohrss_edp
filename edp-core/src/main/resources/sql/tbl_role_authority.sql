
DROP TABLE IF EXISTS "public"."tbl_role_authority";
CREATE TABLE "public"."tbl_role_authority" (
"id" serial,
"role_id" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"authority_id" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tbl_role_authority" IS '角色权限关联表';
COMMENT ON COLUMN "public"."tbl_role_authority"."id" IS '主键';
COMMENT ON COLUMN "public"."tbl_role_authority"."role_id" IS '角色Id';
COMMENT ON COLUMN "public"."tbl_role_authority"."authority_id" IS '权限Id';


CREATE INDEX "tbl_role_authority_role_id_idx" ON "public"."tbl_role_authority" USING btree ("role_id");
CREATE INDEX "tbl_role_authority_authority_id_idx" ON "public"."tbl_role_authority" USING btree ("authority_id");


ALTER TABLE "public"."tbl_role_authority" ADD PRIMARY KEY ("id");
