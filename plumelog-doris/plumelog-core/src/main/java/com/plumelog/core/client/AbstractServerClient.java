package com.plumelog.core.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractServerClient {
    public abstract void insertListLog(List<String> list, String baseIndex, String type) throws Exception;

    public abstract void insertListTrace(List<String> list, String baseIndex, String type) throws Exception;

    public void insertListComm(List<String> list, String baseIndex, String type) throws Exception {
    }

    public abstract boolean deleteIndex(String index) throws IOException;

    public abstract String get(String url, String queryStr) throws Exception;

    public abstract String get(String indexStr, String queryStr, String from, String size, String type) throws Exception;

    public abstract String group(String indexStr, String queryStr) throws Exception;

    public String cat(String index) {
        return null;
    }

    public boolean creatIndice(String indice, String type) {
        return true;
    }

    public boolean setMapping(String indice, String type) {
        return true;
    }

    public boolean creatIndiceTrace(String indice, String type) {
        return true;
    }

    public boolean existIndice(String indice) {
        return true;
    }

    public String getVersion() {
        return "";
    }

    public boolean creatIndiceNomal(String indice, String type) {
        return true;
    }

    public List<String> getExistIndices(String[] indices) {
        return new ArrayList<>();
    }

    public void close() {
    }

    public boolean addShards(Long shardCount) {
        return true;
    }
}
