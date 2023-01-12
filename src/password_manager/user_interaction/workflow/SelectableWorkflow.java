package password_manager.user_interaction.workflow;

public enum SelectableWorkflow {
    CREATE_CREDENTIAL(1),
    EXIT(99)
    ;


    private final int id;

    SelectableWorkflow(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
