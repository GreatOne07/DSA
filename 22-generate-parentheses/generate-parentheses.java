class Solution {
    public List<String> generateParenthesis(int n) {
       List<String> res= new ArrayList<>();
       backtrack(res,"",0,0,n);
       return res; 
    }
    public void backtrack(List<String> res,String ans,int open,int close,int n){
        if(ans.length()==2*n){
            res.add(ans);
            return;
        }
        if(open<n){
            backtrack(res,ans+"(",open+1,close,n);
        }
        if(close<open){
            backtrack(res,ans+")",open,close+1,n);
        }
    }
}