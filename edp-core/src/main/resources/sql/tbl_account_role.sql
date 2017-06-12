
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


insert into tbl_account_role
(role_id,
user_id)
values
(
'ROLE17061213460856008695',
'USER17061213413856038626'
);

insert into tbl_account_role
(role_id,
user_id)
values
(
'ROLE17061213460856008696',
'USER17061211232456024430'
);
