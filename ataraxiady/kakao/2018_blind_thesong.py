import math

def solution(m, musicinfos):
    answer = None
    # #까지 한 글자로 체크해주기보다 그냥 다른 한글자 문자로 치환하는 것이 확인에 용이
    m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a")
    
    for musicinfo in musicinfos:
        start, end, title, code = musicinfo.split(",")
        
        hour, minute = map(int, start.split(":"))
        start = hour * 60 + minute
        
        hour, minute = map(int, end.split(":"))
        end = hour * 60 + minute
        duration = end - start
        
        code = code.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a")
        code *= math.ceil(duration / len(code))
        code = code[:duration]
        
        if m not in code:
            continue
            
        if answer == None or answer[0] < duration or (answer[0] == duration and answer[1] > start):
                answer = (duration, start, title)
    
    if answer:
        return answer[-1]
    
    return "(None)"