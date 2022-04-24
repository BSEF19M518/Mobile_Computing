package com.example.bsef19m518_app2;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Calculator {
    String exp;
    String exp2;
    Character opr;
    boolean flag;

    public Calculator() {
        exp="";
        exp2="";
        opr='\0';
        flag=true;
    }

    public String setExp(String exp) {

        while(exp.length()>0 && exp.charAt(0)== '0')
        {
            exp=exp.substring(1,exp.length());
        }
        this.exp=exp;
        return exp;
    }

    public void AppendNumber(String num)
    {
        setExp(exp+num);
    }
    public boolean isNotOperator(String str)
    {
        String[] operators={"+","-","*","/","=","C"};

        for(String opr:operators)
        {
            if(opr.equals(str))
                return false;
        }
            return true;
    }
    public void calculate(View view,TextView t)
    {
        String inp= String.valueOf(((Button)view).getText());
        if(isNotOperator(inp))
        {
            if(!opr.equals('\0') && flag) {
                setExp("");
                flag=false;
            }
            AppendNumber(inp);
        }
        else if(inp.equals("C"))
        {
            opr='\0';
            exp2=exp="0";
        }
        else
        {
            if(inp.equals("="))
            {
                flag=true;
                switch (opr)
                {
                    case '+':
                          setExp(String.valueOf(Integer.parseInt(exp)+Integer.parseInt(exp2)));
                          break;
                    case '-':
                        setExp(String.valueOf(Integer.parseInt(exp2)-Integer.parseInt(exp)));
                        break;
                    case '*':
                        setExp(String.valueOf(Integer.parseInt(exp)*Integer.parseInt(exp2)));
                        break;
                    case '/':
                        setExp(String.valueOf(Integer.parseInt(exp2)/Integer.parseInt(exp)));
                        break;
                    default:
                        break;
                }
            }
            else
            {

                opr=inp.charAt(0);
                exp2=exp;

            }
        }

        t.setText(exp);
    }
}
