package com.hbase;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * @className:HbaseTest
 * @author:wqkenqing
 * @describe:测试hbaseapi
 * @date:2017/5/24
 **/
public class HbaseTest {

    HBaseAdmin hadmin;
    HBaseConfiguration hconf;
    HTable hTable;
    HTableDescriptor tableDescriptor;
    HColumnDescriptor hcolumd;

    {
        hconf = new HBaseConfiguration();
        hconf.set("hbase.zookeeper.quorum", "wqkenqing01");
        hconf.set("hbase.zookeeper.property.clientPort", "2181");

        try {
            hadmin = new HBaseAdmin(hconf);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void createTable() throws IOException {
        tableDescriptor = new HTableDescriptor(Bytes.toBytes("javaTest"));
        tableDescriptor.addFamily(new HColumnDescriptor("info"));
        hadmin.createTable(tableDescriptor);
        tableDescriptor = hadmin.getTableDescriptor(Bytes.toBytes("javaTest"));
        byte[] name = tableDescriptor.getName();
        System.out.println("table name:" + " " + new String(name));
    }


    public void addData() throws IOException {

        int a = (int) (Math.random() * 100);
        Put put = new Put(Bytes.toBytes("joe" + a));
        hTable = new HTable(hconf, "javaTest");
        put.add(Bytes.toBytes("info"), Bytes.toBytes("tes"), Bytes.toBytes("测试"));
        hTable.put(put);

    }

    public void deleteData() {
        int a = (int) (Math.random() * 100);
        try {
            HTable table = new HTable(hconf, "javaTest");

            Delete delete = new Delete(Bytes.toBytes("joe" + a));
            System.out.println("正在删除joe" + a);
            table.delete(delete);
        } catch (Exception e) {
            System.out.println("这个用户不存在" + "joe" + a);
            System.out.println(e);
        }


    }

    public void getData() {
        int a = (int) (Math.random() * 100);
        try {
            hTable = new HTable(hconf, "javaTest");
            Get get = new Get(Bytes.toBytes("joe" + a));
            Result result = hTable.get(get);

            for (KeyValue keyval : result.raw()) {
                System.out.println("Row name" + new String(keyval.getRow()));
                System.out.println("Timestamp" + new String(keyval.getTimestamp() + ""));
                System.out.println("Row name" + new String(keyval.getFamily()));
                System.out.println("Row name" + new String(keyval.getQualifier()));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        HbaseTest hbaseTest = new HbaseTest();
//        hbaseTest.createTable();
        for (int i = 0; i < 100; i++) {
//            hbaseTest.addData();
//            System.out.println("正在添加第"+i+"条记录");

//            hbaseTest.deleteData();
            hbaseTest.getData();
        }
        System.out.println("--------ending-----");
    }


}
