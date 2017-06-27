/*
 Navicat Premium Data Transfer

 Source Server         : PostgresqlSever
 Source Server Type    : PostgreSQL
 Source Server Version : 90602
 Source Host           : localhost
 Source Database       : MyAdminDBSpring
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90602
 File Encoding         : utf-8

 Date: 06/27/2017 12:02:18 PM
*/

-- ----------------------------
--  Sequence structure for users_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."users_id_seq";
CREATE SEQUENCE "public"."users_id_seq" INCREMENT 1 START 17 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."users_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS "public"."users";
CREATE TABLE "public"."users" (
	"id" int4 NOT NULL DEFAULT nextval('users_id_seq'::regclass),
	"username" varchar(100) COLLATE "default",
	"email" varchar(100) COLLATE "default",
	"gender" varchar(1) COLLATE "default",
	"phonenumber" varchar(100) COLLATE "default",
	"status" varchar(1) COLLATE "default",
	"user_hash" varchar(100) COLLATE "default",
	"created_date" timestamp(6) NULL DEFAULT now()
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."users" OWNER TO "postgres";

-- ----------------------------
--  Records of users
-- ----------------------------
BEGIN;
INSERT INTO "public"."users" VALUES ('1', 'sokheangret', 'sokheangret@gmail.com', 'M', '010445243', 'Y', 'dsfds-dsfsdaf-sdafdsf-dsfa', '2017-06-23 16:49:35.628143');
INSERT INTO "public"."users" VALUES ('11', 'Yeak leang', 'leangyeak@gmail.com', 'F', '099111111', 'Y', '695ae571-f48c-4acd-b196-fdee18fc8ab2', '2017-06-23 18:24:16.253473');
INSERT INTO "public"."users" VALUES ('2', 'chanrathmoeurn', 'chanrathmoeurn@gmail.com', 'F', '016249922', 'N', 'sadfd-dsf-sdfsdf-dfsf', '2017-06-23 16:49:35.628143');
INSERT INTO "public"."users" VALUES ('15', 'horchanpheng', 'chanpenghor@gmail.com', 'M', '098123456', 'y', 'f323d646-c3c3-437f-bdc5-3083cf36e507', '2017-06-27 11:03:38.768645');
INSERT INTO "public"."users" VALUES ('16', 'lengphen', 'lengphen@gmail.com', 'M', '098334455', 'Y', '7e2e50b8-14a2-4f1a-a149-531a2346599a', '2017-06-27 11:05:39.409849');
INSERT INTO "public"."users" VALUES ('17', 'mouykeaann', 'mouykeaann@gmail.com', 'F', '010101010110', 'Y', '07abf0a6-4a18-46fd-be58-aec72522383e', '2017-06-27 11:06:10.920369');
COMMIT;


-- ----------------------------
--  Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."users_id_seq" RESTART 18 OWNED BY "users"."id";
-- ----------------------------
--  Primary key structure for table users
-- ----------------------------
ALTER TABLE "public"."users" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

