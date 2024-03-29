package top.flobby.common.excel;

import java.util.List;

/**
 * @author : Flobby
 * @program : admin-api-template
 * @description :
 * @create : 2023-04-23 17:05
 **/

public interface ExcelFinishCallBack<T> {

    /**
     * 导出后置处理数据
     *
     * @param result result
     */
    void doAfterAllAnalysed(List<T> result);

    /**
     * @param result result
     */
    default void doSaveBatch(List<T> result) {
    }
}
