import re 
def solution(files): 
    answer = [] 
    
    # 정규식을 이용하여 숫자를 기준으로 자른다.
    head_num_tail = [re.split(r"([0-9]+)", file) for file in files]
    # 문자는 소문자 구분이 없게 정렬, 그 후 숫자로 정렬
    sorted_head_num_tail = sorted(head_num_tail, key=lambda x: (x[0].lower(), int(x[1]))) 
    # 정렬된 리스트 안에서 나뉘어진 리스트값을 문자열로 바꾸어 출력한다.
    answer = ["".join(h_n_t) for h_n_t in sorted_head_num_tail] 
    
    return answer

