
DROP TABLE IF EXISTS "public"."tbl_account_role";
CREATE TABLE "public"."tbl_account_role" (
"id" serial,
"role_id" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"user_id" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tbl_account_role" IS '账号角色关联表';
COMMENT ON COLUMN "public"."tbl_account_role"."id" IS '主键';
COMMENT ON COLUMN "public"."tbl_account_role"."role_id" IS '角色Id';
COMMENT ON COLUMN "public"."tbl_account_role"."user_id" IS '用户Id';

CREATE INDEX "tbl_account_role_role_id_idx" ON "public"."tbl_account_role" USING btree ("role_id");
CREATE INDEX "tbl_account_role_user_id_idx" ON "public"."tbl_account_role" USING btree ("user_id");

ALTER TABLE "public"."tbl_account_role" ADD PRIMARY KEY ("id");
