#include <iostream>
#include <string>
using namespace std;

int selectedCount;
int maxCount;
int N, K;
string *words;
bool *visited;

int wordCount(){
        int count=0;

	for(int i=0;i<N;i++){
		bool isPossible=true;
		for(int j=0;j<words[i].length();j++){
			if(visited[words[i][j]-'a']==false){
				isPossible=false;
				break;
			}
		}
		if(isPossible){
			count++;
		}
	}



        return count;
}

void dfs(int index){

        visited[index]=true;
        selectedCount++;

        if(selectedCount==K){
                maxCount=max(maxCount, wordCount());
                
        }
	else{
		for(int i=index+1;i<26;i++){
			if(visited[i]==false){
				dfs(i);
			}
		}
	}

	visited[index]=false;
	selectedCount--;
}




int main() {

	string sc;
	selectedCount=0;

	cin>>N>>K;

	if(K<5){
		cout<<0<<'\n';
		return 0;
	}

	words=new string[N];
	visited=new bool[26];

	visited['a'-'a']=true;
	visited['n'-'a']=true;
	visited['t'-'a']=true;
	visited['i'-'a']=true;
	visited['c'-'a']=true;

	for(int i=0;i<N;i++){
		cin>>sc;
		words[i]=sc;
	}
	
	selectedCount=5;
	maxCount=wordCount();

	for(int i=0;i<26;i++){
		if(visited[i]==false)
			dfs(i);
	}

	cout<<maxCount<<'\n';

	return 0;
}



