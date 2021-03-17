/**
 * 项目名称：equity
 * 类名称：EquityResult
 * 类描述：
 * 创建人：jianghu
 * 创建时间：2018年3月15日 上午9:59:54
 * 修改人：jianghu
 * 修改时间：2018年3月15日 上午9:59:54
 * 修改备注： 上午9:59:54
 *
 * @version
 */
package com.zhishi.appfront.common;

public class EquityResult {
    private String msg;        //错误成功信息

    private Object object;//返回值

    //0 操作正常（例如：查询成功 删除成功 修改成功）
    //-1 参数有误（例如：请填写***参数  ***参数不正确）
    //-2 登录失效
    //-3 处理结果失败（例如：用户状态为挂起不能登录 用户名或者密码错误  删除失败  添加失败 ）
    //-4 服务器错误
    private int state;


    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public EquityResult(String msg, Object object, int state) {
        this.msg = msg;
        this.object = object;
        this.state = state;
    }

    public EquityResult() {
    }
}
