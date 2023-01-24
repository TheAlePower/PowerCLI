package com.thealepower.powercli.cli.view.component.action;

import com.thealepower.powercli.PowerCLI;

public abstract class ActionAsync extends Action {

    @Getter @Setter
    protected Thread currentThread;

    public ActionAsync(PowerCLI owner, int uses) {
        super(owner, uses);
    }

    public ActionAsync(PowerCLI owner) {
        super(owner);
    }

    @Override
    public void run() {
        if (super.getUses() > 0 || super.getUses() == -1) {
            if (super.getUses() != -1) super.setUses(super.getUses() - 1);
            if (currentThread == null) {
                currentThread = new Thread(){
                    @Override
                    public void run() {
                        super.run();
                    }
                };
                currentThread.start();
                // If the thread is alive, do not run anything
            } else {
                if (currentThread.getState() != Thread.State.TERMINATED) {

                }
            }
        }
    }
}
