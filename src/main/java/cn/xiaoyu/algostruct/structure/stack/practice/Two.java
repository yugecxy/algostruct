package cn.xiaoyu.algostruct.structure.stack.practice;

import java.util.Stack;

/**
 * Created by chenxiaoyu
 * Author: chenxiaoyu
 * Date: 2018/5/2
 * Desc:
 */
public class Two {
    public boolean isHuiwen(String raw) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < raw.length(); i++) {
            char tmp = raw.charAt(i);
            if (tmp == 'X') {
                index = i;
                break;
            } else {
                stack.push(tmp);
            }
        }
        if(stack.empty()){
            return false;
        }
        for (int j = index+1;j<raw.length();j++){
            char tmp=raw.charAt(j);
            if(tmp!=stack.pop()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Two().isHuiwen("agXga"));
    }

}
