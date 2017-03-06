/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2017 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.github.pagehelper.sql;

import com.github.pagehelper.parser.CountSqlParser;
import net.sf.jsqlparser.JSQLParserException;
import org.junit.Test;

/**
 * @author liuzh
 */
public class SqlTest {

    @Test
    public void testSqlParser() throws JSQLParserException {
        CountSqlParser countSqlParser = new CountSqlParser();
        System.out.println(countSqlParser.getSmartCountSql("with " +
                "cr as " +
                "( " +
                "    select CountryRegionCode from person.CountryRegion where Name like 'C%' order by name" +
                ") " +
                " " +
                "select * from person.StateProvince where CountryRegionCode in (select * from cr)"));

        System.out.println(countSqlParser.getSmartCountSql("with cr as " +
                " (select aaz093 from aa10 where aaa100 like 'AAB05%' order by aaz093 desc) " +
                "select count(1) from aa10 where aaz093 in (select * from cr)"));


        System.out.println(countSqlParser.getSmartCountSql("select a.aac001,a.aac030,b.aaa103 " +
                "  from ac02 a " +
                "  left join aa10 b " +
                "    on b.aaa100 = 'AAC031' " +
                "   and b.aaa102 = a.aac031 " +
                "   order by a.aac001"));

        System.out.println(countSqlParser.getSmartCountSql("select * from aa10 WHERE aaa100 LIKE 'AAB05%' " +
                "union " +
                "select * from aa10 where aaa100 = 'AAC031'"));

        System.out.println(countSqlParser.getSmartCountSql("select * from (select * from aa10 WHERE aaa100 LIKE 'AAB05%' " +
                "union " +
                "select * from aa10 where aaa100 = 'AAC031')"));
    }

    @Test
    public void testSqlParser2() throws JSQLParserException {
        CountSqlParser countSqlParser = new CountSqlParser();
        System.out.println(countSqlParser.getSmartCountSql("select countryname,count(id) from country group by countryname"));
    }
}
