# 방금그곡
from datetime import datetime
def solution(m, musicinfos):
    def replaceFunc(s) :
        s = s.replace('A#','H')
        s = s.replace('F#','I')
        s = s.replace('C#','J')
        s = s.replace('D#','K')
        s = s.replace('G#','L')
        return s

    candidate = []
    m = replaceFunc(m)
    for i in range(len(musicinfos)):
        start, end, title, melody = musicinfos[i].split(',')
        melody = replaceFunc(melody)
        if not set(list(m)).issubset(set(list(melody))) : continue
        time = str(datetime.strptime(end,'%H:%M')-datetime.strptime(start,'%H:%M')).split(':')
        total = int(time[0])*60 + int(time[1])
        info = {'T':total, 't':title, 'm':melody}
        if len(melody) >= total : 
            if m in melody[:total] : candidate.append(info)
        else :
            q, r = divmod(total,len(melody))
            fullMelody = melody * q + melody[:r]
            if m in fullMelody : candidate.append(info)
    
    if len(candidate) == 1 : return candidate[0]['t']
    elif len(candidate) == 0 : return "(None)"
    max = candidate[0]['T']
    maxIdx = 0
    for i in range(1,len(candidate)):
        if candidate[i]['T'] > max :
            maxIdx = i
            max = candidate[i]['T']
    
    return candidate[maxIdx]['t']