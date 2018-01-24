(ns hedge-test.core)

; hello world handler
(defn hello [req] "Hello, AWS Helsinki Meetup")

; helpers
(def operators {"+" +
                "-" -
                "*" *
                "/" /})

(defn extract-query-parameter
  "Extracts query parameter from req. Returns nil if querystring or parameter is empty"
  ([req parameter default]
   (let [querystring (cljs.nodejs/require "querystring")
         query-string (get req :query-string)]
       (cond
         (nil? query-string) default
         :else
         (goog.object/get (.parse querystring query-string) parameter default))))
  ([req parameter]
   (extract-query-parameter req parameter nil)))

; simple calculator handler
(defn calc
  [req]
  (let [operator (extract-query-parameter req "op" nil)
        value1 (-> (extract-query-parameter req "value1" nil) js/parseInt)
        value2 (-> (extract-query-parameter req "value2" nil) js/parseInt)]
    (cond
      (or (nil? operator) (= js/NaN value1) (= js/NaN value2))
      (throw (js/Error. "Missing input parameter!"))
      (contains? operators operator)
      (str ((get operators operator) value1 value2))
      :else
      (throw (js/Error. "Bad operator type!")))))
