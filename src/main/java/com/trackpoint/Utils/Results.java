package com.trackpoint.Utils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Results {
    private int status;
    private String message;

    private void setStatus(int status){
        this.status = status;
    }
    private void setMessage(String message) {
        this.message = message;
    }
    private Results(int status, String message) {
        this.status = status;
        this.message = message;
    }
    public static Results fail(){return new Results(400,"失败");}
    public static Results success(){return new Results(200,"成功");}

}
