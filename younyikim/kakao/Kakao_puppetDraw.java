package kakao;

import java.util.Stack;

public class Kakao_puppetDraw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] board = { 
							{0,0,0,0,0},
							{0,0,1,0,3},
							{0,2,5,0,1},
							{4,2,4,4,2},
							{3,5,1,3,1}
						};
		int [] moves = {1,5,3,5,1,2,1,4};
		System.out.println(Solution(board, moves));
	}
	
	public static int Solution(int [][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> basket = new Stack<>();
		
		for(int k = 0; k < moves.length; k++) {
			int crane = moves[k] - 1;
			
			for(int i = 0; i < board.length; i++) {
				if(board[i][crane] > 0) {
					if(!basket.isEmpty() && basket.peek() == board[i][crane]) {
						basket.pop();
						answer += 2;
					} else {
						basket.push(board[i][crane]);
					}
					board[i][crane] = 0;
					break;
				}
			}

		}
		
		return answer;
	}

}
