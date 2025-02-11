class Solution {
public:
    string removeOccurrences(string s, string part) {
        int n=s.length();
        int m=part.length();
        if(m>n)return s;
        if(m==n && part==s)return "";

        while(s.find(part)!=string::npos){
            int pos=s.find(part);
            s=s.substr(0,pos)+s.substr(pos+m); 
        }
        
        return s;
    }
};

