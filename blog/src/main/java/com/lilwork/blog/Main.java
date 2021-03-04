package com.lilwork.blog;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        AutoGenerator autoGenerator = new AutoGenerator();
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/lilworkblog?useUnicode=true&characterEncoding=UTF-8");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("creamsoda");
        autoGenerator.setDataSource(dataSourceConfig);

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOpen(true);
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/blog/src/main/java" );
        globalConfig.setAuthor("lil");
        globalConfig.setServiceName("%sService");
        autoGenerator.setGlobalConfig(globalConfig);

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.lilwork.blog");
        packageConfig.setEntity("entity");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setMapper("mapper");
        packageConfig.setController("controller");
        autoGenerator.setPackageInfo(packageConfig);

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        List<TableFill> list = new ArrayList<>();
        list.add( new TableFill("created", FieldFill.INSERT));
        list.add(new TableFill("modified",FieldFill.INSERT_UPDATE));
        strategyConfig.setTableFillList(list); // 自动填充
        autoGenerator.setStrategy(strategyConfig);

        autoGenerator.execute();

    }
}
