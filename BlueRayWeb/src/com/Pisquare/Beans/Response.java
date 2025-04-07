package com.Pisquare.Beans;

import java.util.List;

public class Response {

    private Head head;
    private Reason reason;
    private List<Category> categories;
    private List<State> stateList;

    // Getters and Setters for Response class

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<State> getStateList() {
		return stateList;
	}

	public void setStateList(List<State> stateList) {
		this.stateList = stateList;
	}

	// Inner class Head
    public static class Head {
        private String requestId;
        private String ts;

        // Getters and Setters for Head class

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public String getTs() {
            return ts;
        }

        public void setTs(String ts) {
            this.ts = ts;
        }
    }

    // Inner class Reason
    public static class Reason {
        private String responseCode;
        private String responseReason;

        // Getters and Setters for Reason class

        public String getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(String responseCode) {
            this.responseCode = responseCode;
        }

        public String getResponseReason() {
            return responseReason;
        }

        public void setResponseReason(String responseReason) {
            this.responseReason = responseReason;
        }
    }

    // Inner class Category
    public static class Category {
        private int order;
        private String categoryName;
        private String categoryDesc;
        private String status;
        private String icon;
        private String modifiedDate;
        private List<SubCategory> subCategories;

        // Getters and Setters for Category class

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCategoryDesc() {
            return categoryDesc;
        }

        public void setCategoryDesc(String categoryDesc) {
            this.categoryDesc = categoryDesc;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getModifiedDate() {
            return modifiedDate;
        }

        public void setModifiedDate(String modifiedDate) {
            this.modifiedDate = modifiedDate;
        }

        public List<SubCategory> getSubCategories() {
            return subCategories;
        }

        public void setSubCategories(List<SubCategory> subCategories) {
            this.subCategories = subCategories;
        }

        // Inner class SubCategory
        public static class SubCategory {
            private int subCategoryOrder;
            private String subCategoryName;
            private String subCategoryDesc;
            private String status;
            private String icon;
            private String modifiedDate;

            // Getters and Setters for SubCategory class

            public int getSubCategoryOrder() {
                return subCategoryOrder;
            }

            public void setSubCategoryOrder(int subCategoryOrder) {
                this.subCategoryOrder = subCategoryOrder;
            }

            public String getSubCategoryName() {
                return subCategoryName;
            }

            public void setSubCategoryName(String subCategoryName) {
                this.subCategoryName = subCategoryName;
            }

            public String getSubCategoryDesc() {
                return subCategoryDesc;
            }

            public void setSubCategoryDesc(String subCategoryDesc) {
                this.subCategoryDesc = subCategoryDesc;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getModifiedDate() {
                return modifiedDate;
            }

            public void setModifiedDate(String modifiedDate) {
                this.modifiedDate = modifiedDate;
            }
        }
    }
    
    
    public static class State {
        private String stateName;

        // Getters and setters
        public String getStateName() {
            return stateName;
        }

        public void setStateName(String stateName) {
            this.stateName = stateName;
        }
    }
}
