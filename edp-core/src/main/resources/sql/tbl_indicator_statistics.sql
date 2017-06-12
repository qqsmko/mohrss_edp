
DROP TABLE IF EXISTS "public"."tbl_indicator_statistics";
CREATE TABLE "public"."tbl_indicator_statistics" (
"id" serial,
"indicator_type" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"indicator_name" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"cycle_time" varchar(32) COLLATE "default" DEFAULT ''::character varying NOT NULL,
"cycle_statistics_value" int4 NOT NULL,
"update_time" timestamp(6) NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON TABLE "public"."tbl_indicator_statistics" IS '指标统计记录表';
COMMENT ON COLUMN "public"."tbl_indicator_statistics"."id" IS '主键';
COMMENT ON COLUMN "public"."tbl_indicator_statistics"."indicator_type" IS '指标类型';
COMMENT ON COLUMN "public"."tbl_indicator_statistics"."indicator_name" IS '指标名称';
COMMENT ON COLUMN "public"."tbl_indicator_statistics"."cycle_time" IS '周期 n+(m,h,d,M,y), n为数字';
COMMENT ON COLUMN "public"."tbl_indicator_statistics"."cycle_statistics_value" IS '周期统计值';
COMMENT ON COLUMN "public"."tbl_indicator_statistics"."update_time" IS '更新时间';

ALTER TABLE "public"."tbl_indicator_statistics" ADD UNIQUE ("indicator_name", "indicator_type");


ALTER TABLE "public"."tbl_indicator_statistics" ADD PRIMARY KEY ("id");
