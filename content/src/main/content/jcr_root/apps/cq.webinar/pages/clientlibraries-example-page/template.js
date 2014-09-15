use(function() {
    var Constants = {
        DESCRIPTION_PROP: "jcr:description"
    };

    var title = this.page.getNavigationTitle() || this.page.getTitle() ||
        this.page.getName();

    var description = this.page.getProperties().get(Constants.DESCRIPTION_PROP,
        "").substr(0, this.descriptionLength);

    return {
        title: title,
        description: description
    };
});
