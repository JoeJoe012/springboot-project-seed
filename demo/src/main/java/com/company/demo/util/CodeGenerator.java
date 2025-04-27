package com.company.demo.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CodeGenerator {
    public static void main(String[] args) {
        // 使用 FastAutoGenerator 快速配置代码生成器
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/demo?serverTimezone=GMT%2B8", "root", "root")
                .globalConfig(builder -> {
                    builder.outputDir("src" + File.separator + "main" + File.separator + "java"); // 输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.company.demo") // 设置父包名
                            .entity("entity") // 设置实体类包名
                            .mapper("dao") // 设置 Mapper 接口包名
                            .service("service") // 设置 Service 接口包名
                            .serviceImpl("service.impl") // 设置 Service 实现类包名
                            .xml("mapper")  // 设置 Mapper XML 文件包名
                            // .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "/path/to/xml")) // 设置路径配置信息;
                            .build();
                })
                .strategyConfig((scanner, builder) ->
                        builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                                .entityBuilder()
                                .enableLombok()
                                .enableTableFieldAnnotation()
                                .controllerBuilder()
                                .enableRestStyle()
                                .build())
                .templateEngine(new FreemarkerTemplateEngine()) // 使用 Freemarker 模板引擎
                .execute(); // 执行生成
    }
    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
