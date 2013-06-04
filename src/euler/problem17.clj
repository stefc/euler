(ns euler.problem17)

(def numbers { 1 "one" 2 "two" 3 "three" 4 "four" 5 "five" 6 "six" 7 "seven" 8 "eight" 9 "nine" 
	10 "ten" 20 "twenty" 30 "thirty" 40 "fourty" 50 "fifty" 60 "sixty" 70 "seventy" 80 "eighty" 90 "ninety"
	100 "hundred" 1000 "thousand" 
	11 "elven" 12 "twelve" 13 "thirteen" 14 "fourteen" 15 "fifteen" 16 "sixteen" 17 "seventeen" 18 "eighteen" 19 "nineteen"})

(defn number-to-str [n]
	(loop [no n acc ""]
		(if (= no 0) acc
			(if (< no 21) (recur 0 (cons (numbers no) acc))
				(if (= no 100) (recur 0 (cons numbers no) acc)
					(if (= no 1000) (recur 0 (cons (numbers no) acc))))))))
						(if (> no 100) (recur (- (int (/ no 100 ))))
							()