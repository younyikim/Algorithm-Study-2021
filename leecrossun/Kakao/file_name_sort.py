# 파일명 정렬
import re
def solution(files):

    answer = [re.split(r"([0-9]+)", f) for f in files]
    answer.sort(key= lambda x: (x[0].lower(), int(x[1])))

    return ["".join(s) for s in answer]