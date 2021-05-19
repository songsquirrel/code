drop table T_POWER_DETAIL_USER;
drop table T_POWER_DETAIL_CONSUME;
create table T_POWER_DETAIL_USER
(
    CONS_NO varchar(10) not null,
    CONS_NAME varchar(100),
    ELEC_ADDR varchar(100),
    CONS_SORT_NAME varchar(50),
    TRADE_NAME varchar(100),
    ELEC_TYPE_NAME varchar(100),
    CONTRACT_CAP integer,
    RUN_CAP integer,
    VOLT_CODE varchar(50),
    VOLT_NAME varchar(50),
    HEC_INDUSTRY_NAME varchar(50),
    BUILD_DATE date,
    DUE_DATE date,
    ORG_NO varchar(50),
    ORG_NAME varchar(100),
    MR_SECT_NO varchar(20),
    MR_DAY integer,
    LINK_MAN varchar(50),
    PHONE varchar(20),
    primary key (CONS_NO)
);

create table T_POWER_DETAIL_CONSUME
(
    CONS_NO varchar(10) not null,
    year_no decimal(4,0),
    january decimal(16,0),
    february decimal(16,0),
    march decimal(16,0),
    april decimal(16,0),
    may decimal(16,0),
    june decimal(16,0),
    july decimal(16,0),
    august decimal(16,0),
    september decimal(16,0),
    october decimal(16,0),
    november decimal(16,0),
    december decimal(16,0)
);