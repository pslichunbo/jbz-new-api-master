package io.renren.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public  class GetOrderId {

    public static String getOrderIdByTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("HHmmss");
        String newDate=sdf.format(new Date());
        Long ree=null;
        try {
            Date date = sdf.parse(newDate);
            ree = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String result="";
        Random random=new Random();
        for(int i=0;i<3;i++){
        result+=random.nextInt(3);
        }
        return ree.toString()+result;
    }

}
