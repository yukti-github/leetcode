class Solution {

    StringBuilder asf = new StringBuilder();
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        recursiveParenthesis(0,0,n);
        return list;
    }

    public void recursiveParenthesis(int open, int close, int n)
    {

        if(open==n) {
            int yetClose = close;
            while(close!=n)
            {
                asf.append(')');
                close++;
            }
            list.add(new String(asf));
            while(close!=yetClose)
            {
                asf.deleteCharAt(asf.length()-1);
                close--;
            }

            if(asf.length()>0 && asf.charAt(asf.length()-1)=='(')
                open = open-1;
            else if(asf.length()>0 && asf.charAt(asf.length()-1)==')')
                close = close-1;
            if(asf.length()>0)
                asf.deleteCharAt(asf.length()-1);


            return;
        }

        if(open<n)
        {
            if(open>close)
            {
                asf.append('(');
                recursiveParenthesis(open+1, close, n);
                asf.append(')');
                recursiveParenthesis(open, close+1, n);

            }

            else {
                asf.append('(');
                recursiveParenthesis(open+1, close, n);
            }
        }


        if(asf.length()>0 && asf.charAt(asf.length()-1)=='(')
            open = open-1;
        else if(asf.length()>0 && asf.charAt(asf.length()-1)==')')
            close = close-1;
        if(asf.length()>0)
            asf.deleteCharAt(asf.length()-1);
        return;

    }
}