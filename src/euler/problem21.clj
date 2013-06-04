(ns euler.problem21)

(defn proper-divisors [number]
		(loop [i 1 accu '()]
			(cond
				(>= i number) accu
				(zero? (mod number i)) (recur (inc i) (cons i accu))
				:else (recur (inc i) accu))))

(defn sum-of-divisors [n]
	(apply + (proper-divisors n)))

(defn amicable? [n]
	(let [a (sum-of-divisors n) b (sum-of-divisors a)]
		(and (not= a b) (= b n))))

(defn calc [n]
	(apply + (filter amicable? (range 1 n))))