package com.apsd.performance.service;

import java.io.File;
import java.io.IOException;

/**
 * @author 大稽
 * @date2018/12/3112:55
 */
public interface FileService {
    String uploadFiel(File file, String key)throws IOException;

}
