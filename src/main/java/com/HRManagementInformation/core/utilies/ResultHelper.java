package com.HRManagementInformation.core.utilies;


import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;

// Bu sinif ekstra kod yazmamamiz icin static result metodlari iceriyor.
// Ornek kullanimlarini benim yazdigim User controller kisiminda gorebilirsiniz.

public class ResultHelper {

    public static <T> ResultData<T> created(T data){
        return new ResultData<>(true,Messages.CREATED,"200",data);
    }

    public static <T> ResultData<T> validateError(T data){
        return new ResultData<>(false,Messages.VALIDATE_ERROR,"400",data);
    }

    public static <T> ResultData<T> success(T data){
        return new ResultData<>(true,Messages.OK,"201",data);
    }

    public static Result notFoundError(String message){
        return new Result(false,message,"400");
    }

    public static Result ok(){
        return new Result(true, Messages.OK, "200");
    }
}
