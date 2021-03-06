package com.o2osys.mng.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.o2osys.mng.common.excel.config.ExcelConfig;

@Controller
@RequestMapping("download")
public class DownloadExcelController {

    @GetMapping("excel-xls")
    public ModelAndView xlsView() {
        return new ModelAndView("excelXlsView", getDefaultMap());
    }

    @GetMapping("excel-xlsx")
    public ModelAndView xlsxView() {
        return new ModelAndView("excelXlsxView", getDefaultMap());
    }

    @GetMapping("excel-xlsx-streaming")
    public ModelAndView xlsxStreamingView() {
        return new ModelAndView("excelXlsxStreamingView", getDefaultMap());
    }

    private Map<String, Object> getDefaultMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(ExcelConfig.FILE_NAME, "default_excel");
        map.put(ExcelConfig.HEADER,Arrays.asList("ID", "NAME", "COMMENT"));
        map.put(ExcelConfig.BODY,
                Arrays.asList(
                        Arrays.asList("A", "a", "가"),
                        Arrays.asList("B", "b", "나"),
                        Arrays.asList("C", "c", "다")
                        ));
        return map;
    }
}
