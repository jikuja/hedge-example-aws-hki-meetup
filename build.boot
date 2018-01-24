(set-env!
  :source-paths #{"src"}  
  :resource-paths #{"resources"}  
  :dependencies '[[siili/boot-hedge "0.0.4" :scope "test"]
                  [siili/hedge "0.0.4"]])

(require  '[boot-hedge.aws.core :refer :all])
