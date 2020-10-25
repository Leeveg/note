package com.leeveg.note.dao.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.leeveg.note.dao.domain.Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @Author 李号东
 * @Description 代码生成工具类
 * @Date 08:07 2019-03-17
 * @Param
 * @return
 **/
public class CodeGenUtil {

    /**
     * 根据表自动生成
     *
     * @param packageName 包名
     * @param author      作者
     * @param moduleName  模块名
     * @param tableNames  表名
     */
    public boolean generateByTables(DataSourceConfig dataSourceConfig, String packageName, String author,
                                    String moduleName, List<String> tablePrefixs, List<String> tableNames) {
        // 策略配置
        StrategyConfig strategyConfig = getStrategyConfig(tablePrefixs, tableNames);
        // 全局变量配置
        GlobalConfig globalConfig = getGlobalConfig(author, moduleName);
        // 包名配置
        PackageConfig packageConfig = getPackageConfig(packageName);
        // 自动生成
        atuoGenerator(dataSourceConfig, strategyConfig, globalConfig, packageConfig, moduleName);
        return true;
    }

    /**
     * 集成
     *
     * @param dataSourceConfig 配置数据源
     * @param strategyConfig   策略配置
     * @param config           全局变量配置
     * @param packageConfig    包名配置
     */
    private void atuoGenerator(DataSourceConfig dataSourceConfig, StrategyConfig strategyConfig, GlobalConfig config,
                               PackageConfig packageConfig, String moduleName) {
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化
                return getResourcesOutputDir(moduleName) + "/src/main/resources/mapper/" + tableInfo.getEntityName()
                        + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        new AutoGenerator().setGlobalConfig(config).setDataSource(dataSourceConfig).setStrategy(strategyConfig)
                .setPackageInfo(packageConfig).setCfg(cfg).setTemplate(templateConfig)
                .setTemplateEngine(new VelocityTemplateEngine()).execute();
    }

    /**
     * 设置包名
     *
     * @param packageName 父路径包名
     * @return PackageConfig 包名配置
     */
    private PackageConfig getPackageConfig(String packageName) {
        return new PackageConfig()
                // 包名
                .setParent(packageName).setEntity("domain").setMapper("mapper")
                .setService("service").setServiceImpl("service.impl");
    }

    /**
     * 全局配置
     *
     * @param author     作者
     * @param moduleName 模块名称
     * @return
     */
    private GlobalConfig getGlobalConfig(String author, String moduleName) {
        return new GlobalConfig()
                // 输出路径
                .setOutputDir(getJavaOutputDir(moduleName)).setOpen(false)
                // 是否覆盖
                .setFileOverride(true)
                // 生成基本的resultMap
                .setBaseResultMap(true)
                // 生成基本的SQL片段
                .setBaseColumnList(false)
                // 作者
                .setAuthor(author);
    }

    /**
     * 策略配置
     *
     * @param tableNames 表名
     * @return StrategyConfig
     */
    private StrategyConfig getStrategyConfig(List<String> tablePrefixs, List<String> tableNames) {

        return new StrategyConfig().setEntityLombokModel(true).setTablePrefix(tablePrefixs.toArray(new String[0]))
                // 表名生成策略 下划线转驼峰
                .setNaming(NamingStrategy.underline_to_camel).setColumnNaming(NamingStrategy.underline_to_camel)
                // 需要生成的的表名，多个表名传数组
                .setInclude(tableNames.toArray(new String[0])).setRestControllerStyle(true)
                .setControllerMappingHyphenStyle(true)
                .setSuperEntityClass(Entity.class)
                ;
    }

    /**
     * 配置数据源
     *
     * @return 数据源配置 DataSourceConfig
     */
    @SuppressWarnings("unused")
    private DataSourceConfig getDataSourceConfig() {
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/pre";
        return new DataSourceConfig().setDbType(DbType.MYSQL).setUrl(dbUrl).setUsername("root").setPassword("root")
                .setDriverName("com.mysql.jdbc.Driver");
    }

    /**
     * 根据模块名返回项目java路径
     *
     * @param projectName 项目名
     * @return 项目路径
     */
    private String getJavaOutputDir(String projectName) {
        String path = Objects.requireNonNull(this.getClass().getClassLoader().getResource("")).getPath();
        int index = path.indexOf(projectName);
        return "/" + path.substring(1, index) + projectName + "/src/main/java/";
    }

    /**
     * 根据模块名返回项目路径
     *
     * @param projectName 项目名
     * @return 项目路径
     */
    private String getResourcesOutputDir(String projectName) {
        String path = Objects.requireNonNull(this.getClass().getClassLoader().getResource("")).getPath();
        int index = path.indexOf(projectName);
        return "/" + path.substring(1, index) + projectName;
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/note?useUnicode=true&serverTimezone=GMT%2B8&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false";
        String username = "root";
        String password = "123456";
        String driverName = "com.mysql.cj.jdbc.Driver";
        CodeGenConfig codeGenConfig = new CodeGenConfig();
        codeGenConfig.setPackageName("com.leeveg.note.dao");
        codeGenConfig.setAuthor("leeveg");
        codeGenConfig.setModuleName("note-dao");
        codeGenConfig.setTablePrefix("d_");
        codeGenConfig.setTableName("d_story_part");
//        codeGenConfig.setComments("摘抄，素材，笔记");
        DataSourceConfig dataSourceConfig = new DataSourceConfig().setDbType(DbType.MYSQL).setUrl(url)
                .setUsername(username).setPassword(password).setDriverName(driverName);
        CodeGenUtil codeGenUtil = new CodeGenUtil();
        codeGenUtil.generateByTables(dataSourceConfig, codeGenConfig.getPackageName(), codeGenConfig.getAuthor(),
                codeGenConfig.getModuleName(), Arrays.asList(codeGenConfig.getTablePrefix()),
                Arrays.asList(codeGenConfig.getTableName()));
    }
}
