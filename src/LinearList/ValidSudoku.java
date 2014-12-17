package LinearList;

public class ValidSudoku {
	static void fill(Boolean[]check){
		for(int i=0;i<check.length;i++){
			check[i]=false;
		}
	}
	static Boolean used(Boolean[]check,char c){
		if(c=='.')
			return false;
		if(check[c-'1'])
			return true;
		check[c-'1']=true;
		return false;
	}
    static Boolean isValidSudoku(char[][]board){
    	Boolean check = true;
    	Boolean col[]=new Boolean[9];
    	Boolean row[]=new Boolean[9];
    	for(int i=0;i<9;i++){
    		fill(row);
    		for(int j=0;j<9;j++){
    			if(used(row,board[i][j])){
    				System.out.println(i+" "+j+" ");
    				return false;
    			}
    			
    		}
    		fill(col);
    		for(int j=0;j<9;j++){
    			if(used(col,board[j][i])){
    				System.out.println(j+" "+i+" ");
    				return false;
    			}
    		}
    	}
    	for(int i=0;i<3;i++){
    		for(int j=0;j<3;j++){
    			fill(col);
    			for(int k=i*3;k<i*3+3;k++){
    				for(int r=j*3;r<j*3+3;r++){
    					if(used(col,board[k][r])){
    						System.out.println(k+" "+r+" ");
    						return false;
    					}
    				}
    			}
    		}
    	}
    	return check;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][]board=
			{
				{'1','2','3' ,'4','5','6', '7','8','9'},
				{'4','.','6', '7','8','9', '1','2','3'},
				{'7','8','9', '1','2','3', '4','5','6'},
				
				{'3','1','2', '5','6','4', '9','7','8'},
				{'5','6','4', '8','9','7', '3','1','2'},
				{'8','9','7', '3','1','2', '5','6','4'},
				
				{'2','3','1', '6','4','5', '8','9','7'},
				{'6','4','5', '9','7','8', '2','3','1'},
				{'9','7','8', '2','3','1', '6','4','5'}
			};
		System.out.println(isValidSudoku(board));
	}

}
