package com.zimo.utils.wxPush;

import com.zjiecode.wxpusher.client.WxPusher;
import com.zjiecode.wxpusher.client.model.Message;
import com.zjiecode.wxpusher.client.model.MessageDataValueItem;
import com.zjiecode.wxpusher.client.model.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/5/5,9:26 AM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class WxClient {

    public static void main(String args[]){
        String userId = "orPQ800ePAFkkzyGoQDW9DE4I6rsBDvnt7mBSh";
        WxPusher.send("这是一个消息",userId);

        List<String> ids = new ArrayList<>();
        ids.add(userId);//替换成你的userId,微信关注“wxpusher”可以获取你自己的id
        Map<String, MessageDataValueItem> data = new HashMap<>();
        data.put("first", new MessageDataValueItem("标题", "#FF0000"));//字段内容和文字颜色
        data.put("keyword1", new MessageDataValueItem("keyword1", "#000000"));
        data.put("keyword2", new MessageDataValueItem("keyword2", "#000000"));
        data.put("keyword3", new MessageDataValueItem("keyword3", "#000000"));
        data.put("remark", new MessageDataValueItem("remark"));
        Message message = new Message();
        message.setUserIds(ids);
        message.setData(data);
//模版ID在 http://wxpusher.dingliqc.com/#part-4 可以查看。
        message.setTemplate_id("lpO9UoVZYGENPpuND3FIofNueSMJZs0DMiU7Bl1eg2c");
        Result result = WxPusher.send(message);
        if (result.isSuccess()) {
            //成功
            System.out.println("发送成功：" + result.getMsg());
        } else {
            //失败
            System.out.println("发送失败：" + result.getMsg());
        }
    }
}
