package com.example.bsef19m518_app2;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Calculator {
    String exp;
    String exp2;
    Character opr;

    public Calculator() {
        exp="";
        exp2="";
        opr='\0';
    }

    public void AppendNumber(String num)
    {
        exp+=num;
    }
    public boolean isNotOperator(String str)
    {
        String[] operators={"+","-","*","/","="};

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
            AppendNumber(inp);
        }
        else
        {
            if(inp.equals("="))
            {
                switch (opr)
                {
                    case '+':
                          exp= String.valueOf(Integer.parseInt(exp)+Integer.parseInt(exp2));
                          break;
                    case '-':
                        exp= String.valueOf(Integer.parseInt(exp)-Integer.parseInt(exp2));
                        break;
                    case '*':
                        exp= String.valueOf(Integer.parseInt(exp)*Integer.parseInt(exp2));
                        break;
                    case '/':
                        exp= String.valueOf(Integer.parseInt(exp2)/Integer.parseInt(exp));
                        break;
                    default:
                        break;
                }
            }
            else
            {
                opr=inp.charAt(0);
                exp2=exp;
                exp="";
            }
        }

        t.setText(exp);
    }
}
