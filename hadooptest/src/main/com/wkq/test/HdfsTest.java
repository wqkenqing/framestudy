package com.wkq.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.junit.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by wqkenqing on 2017/4/19.
 */
public class HdfsTest {
    //hdfsApi测试
    /*
    * hdfs地址
    * */
    String hpath = "hdfs://hadoop221:8020";
    Configuration conf = new Configuration();
    FileSystem fs = FileSystem.get(URI.create(hpath), conf);

    public HdfsTest() throws IOException {
    }

    public void testHDFSmkdir() throws IOException {
        Path path = new Path("/wkq/hdfs");
        boolean b = fs.mkdirs(path);
        System.out.println(b);
    }

    @Test
    public void testHFileGet() throws IOException {
        System.out.println(fs.getChildFileSystems());
        System.out.println(fs.getCanonicalServiceName());
        Path path = new Path("/log/abc/2017-03-31.1490931609940");
//        RemoteIterator<LocatedFileStatus> files=   fs.listFiles(path,true);
//        while (files.hasNext()) {
//            System.out.println(files.next());
//        }
        try {
            FSDataInputStream hdfsInStream = fs.open(path);
            byte[] ioBuffer = new byte[1024];
            int readLen = hdfsInStream.read(ioBuffer);
            while (readLen != -1) {
//                System.out.write(ioBuffer, 0, readLen);
                System.out.println(hdfsInStream.read(ioBuffer));
                System.out.println(readLen);
            }

            hdfsInStream.close();
            fs.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testHfileRead() {
        Path path = new Path("/log/abc/2017-03-31.1490931609940");
        FileSystem fs = null;
        URI uri;
        try {
            uri = new URI(hpath);
            fs = FileSystem.get(uri, conf);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream in = null;
        try {
            in = fs.open(path);
            IOUtils.copyBytes(in, System.out, 4096, false);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(in);
        }
    }
}
